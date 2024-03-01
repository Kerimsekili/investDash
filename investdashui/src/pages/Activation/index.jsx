import { useParams } from "react-router-dom";

export function Activation() {
  const { token } = useParams();
  return <h1>Activation</h1>;
}
