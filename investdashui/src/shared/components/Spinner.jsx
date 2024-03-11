export function Spinner(props) {
  const { small } = props;
  return (
    <span
      className={`spinner-border ${small ? "spinner-border-sm" : ""}`}
      aria-hidden="true"
    ></span>
  );
}
