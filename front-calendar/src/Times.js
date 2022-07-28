import React from 'react'
import {useState} from 'react';
import './Calendar.css';

const time = ['09:00 to 09:15','10:00 to 10:15','11:00 to 11:15',
              '09:15 to 09:30','10:15 to 10:30', '11:15 to 11:30',
              '09:30 to 09:45', '10:30 to 10:45', '11:30 to 11:45']
// let cpt = 0
function Times(props) {

 const [event, setEvent] = useState(null)
 const [info, setInfo] = useState(false)

 function displayInfo(e) {
   setInfo(true);
   setEvent(e.target.innerText);
   const dates = e.target.innerText
   parseDate(dates)
}

function parseDate(dates) {
  const creneau = dates.split(' ')
  const start = creneau[0]
  const end = creneau[2]
  console.log(start)
  console.log(end)
}

function InputTitle(props) {
  return (
    <div style={{float: 'left', marginTop: 10}}>
      <label htmlFor='titleEvent'>title: </label>
      <input type="texte" id="titre" name="titres" />
    </div>
  )
}

return (
 
    <div className='times'>
      <div className='ButtonTitle'>
        <div className='Bouton' >
        {time.map((currTime) => {
        return (
        <div>
          <button style={{ color: "black", backgroundColor: "#decddd", float: 'left'}} onClick={(e)=> displayInfo(e)}> {currTime} </button>
        </div>
            )
          })}
        </div>
          {info ? <InputTitle /> : null}
      </div>

       <p style={{float : 'left'}}>
         {info ? `Your appointment is set from: ${event} ${props.date.toDateString()}` : null}
       </p>
    </div>
     )
}

export default Times;