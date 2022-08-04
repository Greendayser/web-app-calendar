import React, { useEffect } from 'react'
import {useState} from 'react';
import './Calendar.css';
import { Form } from './Form';
import { useForm } from "react-hook-form";
import { dataArr, formatDate } from './App';
import { getAvailabilitiesOfDay } from './Request';

const time = ['09:00 to 09:15','10:00 to 10:15','11:00 to 11:15',
              '09:15 to 09:30','10:15 to 10:30', '11:15 to 11:30',
              '09:30 to 09:45', '10:30 to 10:45', '11:30 to 11:45']




function Times(props) {

 const [event, setEvent] = useState(null)
 const [info, setInfo] = useState(false)
 const [availabilities, setAvailabilities] = useState([])

//  console.log(dataArr)

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
  dataArr.add(start)
  dataArr.add(end)
}


useEffect(() => {

  let day = formatDate(props.date)
  // fetch("http://localhost:8080/calendar/availabilities/get/day/" + day)
  // .then(response => {
  //   return response.json()
  // }).then(data => {
  //   console.log(data)
  //   const t = data.map((currTime) => {
  //     return currTime.start + " to " + currTime.end
  //   })
  //   console.log(t)
  //   // return t.map((currTime) => {
  //   //   return <option value={currTime} onClick={(e) => displayInfo(e)}>{currTime}</option>
  //   // })
  //   setAvailabilities(t)
  // })
  const fetchData = async (day) => {
    const response = await fetch("http://localhost:8080/calendar/availabilities/get/day/" + day)
    const responseJson = await response.json()

    setAvailabilities(responseJson)
  }
  
  fetchData(day)

}, [])


console.log(availabilities)

const { register, handleSubmit } = useForm();
  const onSubmit = data => console.log(data);

return (
 
    <div className='times'>
      <div className='ButtonTitle'>
        <div className='Bouton' >

          <form onSubmit={handleSubmit(onSubmit)}>

            <label htmlFor='timeSlot'>Select a time slot: </label>
            <select {...register("timeSlot")}>

              {/* {time.map((currTime) => {
                return <option value={currTime} onClick={(e) => displayInfo(e)}>{currTime}</option>
              })} */}

              {/* {Test()} */}

            {availabilities.map((currTime) => {
              return <option value={currTime.start + " to " + currTime.end} onClick={(e) => displayInfo(e)}>{currTime.start} to {currTime.end}</option>
            })}

            </select>

          </form>
        </div>
          {info ? <Form /> : null}
          
      </div>

        
       <p style={{float : 'left', marginRight: 15}}>
         {info ? `Your appointment is set from: ${event} ${props.date.toDateString()}` : null}
       </p>
       
    </div>
     )
}

export default Times;