import React, { useState } from 'react';

function App() {
  const [data, setData] = useState([]);
  const [formData, setFormData] = useState({
    name: '',
    email: ''
  });

  const handleInputChange = event => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    });
  };

  const handleSubmit = event => {
    event.preventDefault();
    fetch('http://localhost:3001/api/data', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData)
    })
      .then(response => response.text())
      .then(message => alert(message))
      .catch(error => console.error(error));
  };

  const handleGetAllData = () => {
    fetch('http://localhost:3001/api/data')
      .then(response => response.json())
      .then(data => setData(data))
      .catch(error => console.error(error));
  };

  return (
    <div>
      <h1>React and Node.js-based REST API Example</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input type="text" name="name" value={formData.name} onChange={handleInputChange} />
        </label>
        <label>
          Email:
          <input type="email" name="email" value={formData.email} onChange={handleInputChange} />
        </label>
        <button type="submit">Submit</button>
      </form>
      <button onClick={handleGetAllData}>Get All Data</button>
      <ul>
        {data.map(item => (
          <li key={item.id}>
            <h2>{item.name}</h2>
            <p>{item.email}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;