import { useTranslation } from "react-i18next";
import { Link } from "react-router-dom";
import logo from "../../assets/logo.png";

export function NavBar() {
  const { t } = useTranslation();
  return (
    <nav className="navbar navbar-expand bg-body-teritary bg-light shadow-sm">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          <img src={logo} alt="InvestDash" width="60" />
          InvestDash
        </Link>
        <ul className="navbar-nav">
          <li className="nav-item">
            <Link className="nav-link" to="/signup">
              {t("signUp")}
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}
