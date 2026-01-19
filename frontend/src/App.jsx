import { useState } from "react";
import StudentForm from "./StudentForm";
import StudentList from "./StudentList";
import { getAllStudents } from "./api";
import "./styles.css";

function App() {
  const [students, setStudents] = useState([]);
  const [selected, setSelected] = useState(null);

  const refresh = async () => {
    const res = await getAllStudents();
    setStudents(res.data);
    setSelected(null);
  };

  return (
    <div className="container">
      <StudentForm selected={selected} refresh={refresh} />
      <StudentList
        students={students}
        setStudents={setStudents}
        onSelect={setSelected}
      />
    </div>
  );
}

export default App;
