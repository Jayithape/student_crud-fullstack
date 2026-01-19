import { getAllStudents, deleteStudent } from "./api";

function StudentList({ students, setStudents, onSelect }) {

  const load = async () => {
    const res = await getAllStudents();
    setStudents(res.data);
  };

  const remove = async (id) => {
    if (!id) return alert("ID missing");
    await deleteStudent(id);
    load();
  };

  return (
    <div className="card">
      <h2>All Students</h2>
      <button className="primary" onClick={load}>Get All</button>

      {students.map((s) => (
        <div className="student-row" key={s.id}>
          <div>
            <strong>{s.name}</strong> | Age: {s.age}
          </div>

          <div className="actions">
            <button className="update" onClick={() => onSelect(s)}>
              Update
            </button>
            <button className="delete" onClick={() => remove(s.id)}>
              Delete
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default StudentList;
