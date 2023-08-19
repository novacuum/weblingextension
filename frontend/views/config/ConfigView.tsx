import { ConfigEndpoint } from "Frontend/generated/endpoints";
import { Button } from "@hilla/react-components/Button.js";
import { TextField } from "@hilla/react-components/TextField.js";

let config = await ConfigEndpoint.get();

function saveConfig(){
  ConfigEndpoint.save(config).then(()=>ConfigEndpoint.get().then((value)=>config = value));
}

export default function ConfigView() {
  return (
    <>
    <TextField label="Host" onValueChanged={({ detail: { value } }) => config.host = value} value={config.host} clearButtonVisible />
    <TextField label="ApiKey" onValueChanged={({ detail: { value } }) => config.apiKey = value} value={config.apiKey} clearButtonVisible />
    <Button onClick={saveConfig}>Save</Button>
    </>
  );
}
