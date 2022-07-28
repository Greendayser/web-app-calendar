import {useForm} from 'react-hook-form'
import React from 'react'
// import {dataArr} from './Times.js'

// function parseData(data) {
//     let title = data.title
//     let mail = data.email
//     // console.log(title)
//     // console.log(mail)
//     dataArr.push(title)
//     dataArr.push(mail)
//     console.log(dataArr)
// }



const wait = function(duration = 1000) {
    return new Promise((resolve) => {
        window.setTimeout(resolve, duration)
    })
}



export function Form() {
    const {register, handleSubmit, formState, formState: {errors}} = useForm()
    const {isSubmitting, isSubmitSuccessful} = formState

    const onSubmit = async (data) => {
        await wait(2000)
        console.log(data)
        // parseData(data)
    }

    console.log(errors)

    return (
        <form className='Container-InputTitle' onSubmit={handleSubmit(onSubmit)} style={{float: 'left'}}> 

        <div className='InputTitle' style={{marginTop: 10}} >
            <label htmlFor='titleEvent'>Title: </label>
            <input type="text" className='form-control' id="title"
                name="title" {...register('title', {required: 'You should enter a title'})}/>

            {errors.title && <span>{errors.title.message}</span>}
        </div>

        <div className='InputEmail' style={{ marginTop: 10}}>
            <label htmlFor='email'>Email: </label>
            <input type="text" className='form-control' id="email"
                name="email" {...register('email', {required: 'You should enter an email'})}/>
        </div>

        <button disabled={isSubmitting} className='btn-send' style={{float: 'left', marginTop: 10, marginLeft: 5}}>Send</button>
      
      {isSubmitSuccessful && <div className='SubmitSuccess' style={{float: 'right', marginTop: 10, marginLeft: 5}}>Your appointment is confirmed</div>}

      </form>
    )
  }



{/* <form onSubmit={handleSubmit(onSubmit)} style={{float: 'left'}}>
            <div >
                <input {...register("title")} style={{ marginTop: 10}} placeholder="Title of the event"/>           
            </div>
            <div>
                <input {...register("email")} placeholder="email" />           
            </div>
            <div>
            <input type="submit" />
            </div>
      </form> */}