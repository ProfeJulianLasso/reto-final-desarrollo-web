import { deleteFunction } from "../Model/LogModel/Log.service.mjs";
import {getByIdFunction} from "../Model/TaskModel/Task.Service.mjs"
import { Url_Log as urlLog } from "./config.mjs";

/**
 * Funcion para valida los campos de la tarea
 * @param {String} inputTitleModal 
 * @param {String} txtAreaDescripcion 
 * @param {String} inputDeliveryDate 
 * @param {HTML tag} inputRdBtn1 
 * @param {HTML tag} inputRdBtn2 
 * @param {HTML tag} inputRdBtn3 
 */
export const validar = (inputTitleModal,txtAreaDescripcion,inputDeliveryDate,inputRdBtn1,inputRdBtn2,inputRdBtn3) =>{

    const bool = ((inputRdBtn1.checked || inputRdBtn2.checked || inputRdBtn3.checked) == false)
    return !(inputTitleModal.value.length && txtAreaDescripcion.value.length && inputDeliveryDate.value.length !=0) || bool;

}

/**
 * funcion para 
 * @param {HTML tag} inputRdBtn1 
 * @param {HTML tag} inputRdBtn2 
 * @returns 
 */
export const btnChecked = (inputRdBtn1,inputRdBtn2) =>{

    if(inputRdBtn1.checked ){
        return 1
    }else if(inputRdBtn2.checked){
        return 2
    }else{
        return 3
    }
    
}

/**
 * funcion para revisar la columna a la que pertenece una tarea
 * @param {String} task 
 * @param {HTML tag} divTask 
 * @param {HTML tag} divTodo 
 * @param {HTML tag} divInprocess 
 * @param {HTML tag} divFinish 
 */
export const columnCheck = (task, divTask,divTodo,divInprocess,divFinish) => {
    task.column === 1 ? divTodo.append(divTask) : task.column === 2? divInprocess.append(divTask):
            divFinish.append(divTask)
}

/**
 * Funcion para actualizar los datos de una tarea
 * @param {Number} taskId 
 * @param {HTML tag} btnCrearActualizar 
 * @param {String} urlTask 
 * @param {HTML tag} inputTitleModal 
 * @param {HTML tag} txtAreaDescripcion 
 * @param {HTML tag} inputDeliveryDate 
 * @param {HTML tag} inputRdBtn1 
 * @param {HTML tag} inputRdBtn2 
 * @param {HTML tag} inputRdBtn3 
 */
export const actualizarDatosTarea = async (taskId,btnCrearActualizar,urlTask,inputTitleModal,txtAreaDescripcion,inputDeliveryDate,inputRdBtn1,inputRdBtn2,inputRdBtn3) => {
 
    if(btnCrearActualizar.innerHTML === "Editar"){

        const dataFind = await getByIdFunction(urlTask, taskId)
        const data = dataFind.data
        const tituloTareaSeleccionada = data.name
        const descripcionTareaSeleccionada = data.description
        const entregaTareaSeleccionada =  data.delivery?.slice(0,10)
        const columnaTareaSeleccionada = data.column

        localStorage.setItem("columnaTareaSeleccionada", columnaTareaSeleccionada)

        inputTitleModal.value = tituloTareaSeleccionada
        txtAreaDescripcion.value = descripcionTareaSeleccionada
        inputDeliveryDate.value = entregaTareaSeleccionada

        columnaTareaSeleccionada === 1 ? inputRdBtn1.checked = true :
        columnaTareaSeleccionada === 2 ? inputRdBtn2.checked = true : inputRdBtn3.checked = true

    }

}

/**
 * funcion para eliminar un Log
 * @param {Number} idLog 
 */
export const eliminarLog = async(idLog)=>{

    await deleteFunction(urlLog, idLog)

}