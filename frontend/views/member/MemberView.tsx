import { MemberEndpoint } from 'Frontend/generated/endpoints';
import { Grid } from '@hilla/react-components/Grid.js';
import { Button } from "@hilla/react-components/Button.js";
import { GridSortColumn } from '@hilla/react-components/GridSortColumn.js';
import { useEffect, useState } from 'react';
import Member from 'Frontend/generated/ch/slackattack/webling/repo/Member';

export default function MemberView() {
  const [members, setMembers] = useState<Member[]>([]);

  useEffect(() => {
    MemberEndpoint.findAll().then(members=>setMembers(members));
  }, []);

  return (
    <>
    <Button
      onClick={async () => {
        await MemberEndpoint.sync();
        setMembers(await MemberEndpoint.findAll());
      }}
    >
      Sync
    </Button>
    <Grid items={members}>
      <GridSortColumn path="email" />
      <GridSortColumn path="firstName" />
      <GridSortColumn path="lastName" />
      <GridSortColumn path="debitors" />
    </Grid>
    </>
  );
}
