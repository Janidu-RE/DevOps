import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import './App.css'
import './index.css'

import LoginPage from './pages/LoginPage'
import Signup from './pages/Signup'
import Home from './pages/Home'

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<Signup/>} />
      </Routes>
    </Router>
  )
}

export default App
