import {useState} from 'react';
import Calendar from 'react-calendar'; 
import './Calendar.css';
import Time from './Time.js'
// import 'react-calendar/dist/Calendar.css';

let dataArr = new Set()

export function formatDate(date) {
  var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

  if (month.length < 2) 
      month = '0' + month;
  if (day.length < 2) 
      day = '0' + day;

  return [year, month, day].join('-');
}

function parseDatas (date) {
  dataArr.clear()
  let dateFormat = formatDate(date)
  dataArr.add(dateFormat)
  // console.log(dateFormat)
}



function App() {

 const [date, setDate] = useState(new Date())
 const [showTime, setShowTime] = useState(false)
 const [datesformat, setDatesfotmat] = useState(formatDate(new Date()))

 return (
 <div className="app">
   <div className="calendar-container">
    <h1 className="title">Booking Calendar</h1>
        <Calendar
          onChange={setDate}
          value={date}
          onClickDay={() => setShowTime(true)}
        />

        {parseDatas(date)}

        
          
        <p style={{position: 'relative'}}>
          <span>Selected date:</span>{' '} {date.toDateString()}
        </p>
        

        <Time showTime={showTime} date ={date} dateform = {formatDate(date)}/>

   </div>
  </div>
  )
}

export {dataArr}
export default App;