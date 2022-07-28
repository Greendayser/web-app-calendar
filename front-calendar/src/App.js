import {useState} from 'react';
import Calendar from 'react-calendar'; 
import './Calendar.css';
import Time from './Time.js'
// import 'react-calendar/dist/Calendar.css';

function App() {
 const [date, setDate] = useState(new Date())
 const [showTime, setShowTime] = useState(false) 

return (
 <div className="app">
   <div className="calendar-container">
   <h1 className="title">Booking Calendar</h1>
      <Calendar
        onChange={setDate}
        value={date}
        onClickDay={() => setShowTime(true)}
      />
    
      {date.length > 0 ? (
        <p>
          <span>Start:</span>{' '} {date[0].toDateString()}
          {' '} to {' '}
          <span>End:</span> {date[1].toDateString()}
        </p>
        ) : (
        <p>
          <span>Selected date:</span>{' '} {date.toDateString()}
        </p>
        )}

      <Time showTime={showTime} date ={date}/>
   </div>
  </div>
  )
}

export default App;