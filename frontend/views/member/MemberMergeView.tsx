import { MemberEndpoint } from "Frontend/generated/endpoints";
import { Grid } from "@hilla/react-components/Grid.js";
import { Button } from "@hilla/react-components/Button.js";
import { GridSortColumn } from "@hilla/react-components/GridSortColumn.js";
import { GridColumn } from "@hilla/react-components/GridColumn.js";
import { ConfirmDialog } from "@hilla/react-components/ConfirmDialog.js";
import { Details } from "@hilla/react-components/Details.js";
import { VerticalLayout } from "@hilla/react-components/VerticalLayout.js";
import { Checkbox } from "@hilla/react-components/Checkbox.js";
import { CheckboxGroup } from "@hilla/react-components/CheckboxGroup.js";
import Member from "Frontend/generated/ch/slackattack/webling/repo/Member";
import DuplicateMember from "Frontend/generated/ch/slackattack/webling/endpoints/model/DuplicateMember";
import { useEffect, useState } from "react";

interface MemberWithScore extends Member {
  score: number;
}

export default function MemberMergeView() {
  const [opened, setOpened] = useState(false);
  const [currentSelected, setCurrentSelected] = useState<DuplicateMember>({});
  const [members, setMembers] = useState<(DuplicateMember | undefined)[]>([]);
  const [compareConfig, setCompareConfig] = useState<string[]>([
    "email",
    "firstName",
    "lastName",
  ]);

  const changeCompareConfig = function (value: string[]) {
    setCompareConfig(value);
  };

  useEffect(() => {
    MemberEndpoint.findAllDuplicates(
      compareConfig.includes("email"),
      compareConfig.includes("firstName"),
      compareConfig.includes("lastName")
    ).then((members) => setMembers(members));
  }, [compareConfig]);

  const selectAndOpen = function (selected: DuplicateMember) {
    selected.duplicates?.forEach((member: (Member|undefined)) => {
      const memberWithScore = member as MemberWithScore;
      const data = JSON.parse(memberWithScore.properties ?? "{}");
      let score = Math.floor(
        (Date.parse(data.Eintrittsdatum) - 1262296800) / 2628000
      );
      score += Object.keys(data).length;
      memberWithScore.score = score;
    });

    selected.duplicates?.sort(
      (a, b) => (b as MemberWithScore).score - (a as MemberWithScore).score
    );
    setCurrentSelected(selected);
    setOpened(true);
  };

  return (
    <>
      <ConfirmDialog
        opened={opened}
        onOpenedChanged={({ detail: { value } }) => setOpened(value)}
        header="Merge View"
        confirmText="Close"
      >
        <Grid items={currentSelected.duplicates}>
          <GridSortColumn path="score" />
          <GridSortColumn path="id" />
          <GridSortColumn path="debitors" />
          <GridSortColumn path="groups" width="60em" />
          <GridColumn path="properties" />
        </Grid>
      </ConfirmDialog>

      <Details summary="Summary" opened>
        <VerticalLayout>
          <dl>
            <dt>Duplicates:</dt>
            <dd>{members.length}</dd>
            <dt>All records:</dt>
            <dd>
              {members.reduce(
                (prev, item) => (item?.duplicates?.length || 0) + prev,
                0
              )}
            </dd>
          </dl>
        </VerticalLayout>
      </Details>

      <Grid items={members}>
        <GridSortColumn header="Num duplicates" path="duplicates.length" />
        <GridSortColumn path="main.email" />
        <GridSortColumn path="main.firstName" />
        <GridSortColumn path="main.lastName" />
        <GridColumn header="Debitors">
          {({ item }) =>
            item.duplicates
              .map((item: Member) => item.debitors)
              .filter((debitors: String) => debitors)
              .join(",")
          }
        </GridColumn>
        <GridColumn header="Action">
          {({ item }) => (
            <Button onClick={() => selectAndOpen(item)}>Show details</Button>
          )}
        </GridColumn>
      </Grid>
      <CheckboxGroup
        label="Compare with"
        value={compareConfig}
        onValueChanged={(event) => changeCompareConfig(event.detail.value)}
        theme="horizontal"
      >
        <Checkbox value="email" label="Email" />
        <Checkbox value="firstName" label="first name" />
        <Checkbox value="lastName" label="last name" />
      </CheckboxGroup>
    </>
  );
}
