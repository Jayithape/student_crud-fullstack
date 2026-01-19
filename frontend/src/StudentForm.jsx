import { useEffect, useState } from "react";
import { addStudent, updateStudent } from "./api";

function StudentForm({ selected, refresh }) {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");

  useEffect(() => {
    if (selected) {
      setName(selected.name);
      setAge(selected.age);
    }
  }, [selected]);

  const submit = async () => {
    if (selected && selected.id) {
      await updateStudent(selected.id, { name, age });
    } else {
      await addStudent({ name, age });
    }
    setName("");
    setAge("");
    refresh();
  };

  return (
    <div className="card">
      <h2>{selected ? "Update Student" : "Add Student"}</h2>

      <input
        placeholder="Student Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <input
        placeholder="Age"
        type="number"
        value={age}
        onChange={(e) => setAge(e.target.value)}
      />

      <button className="primary" onClick={submit}>
        {selected ? "Update" : "Add"}
      </button>
    </div>
  );
}

export default StudentForm;
