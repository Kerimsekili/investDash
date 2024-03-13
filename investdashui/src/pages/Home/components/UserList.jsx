import { useEffect, useState } from "react";
import { loadUsers } from "./api";

export function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    async function getUsers() {
      const response = await loadUsers();
      setUsers(response.data);
    }
    getUsers();
  }, []);

  return (
    <div>
      <h1>User List</h1>
      {users.map((user) => {
        return <div> {user.username}</div>;
      })}
    </div>
  );
}
