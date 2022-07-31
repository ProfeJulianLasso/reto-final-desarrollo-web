import { deleteFunction } from "../Model/LogModel/Log.service.mjs";
import {getByIdFunction} from "../Model/TaskModel/Task.Service.mjs"
import { Url_Log as urlLog } from "./config.mjs";

export const validar = (inputTitleModal,txtAreaDescripcion,inputDeliveryDate,inputRdBtn1,inputRdBtn2,inputRdBtn3) =>{

    const bool = ((inputRdBtn1.checked || inputRdBtn2.checked || inputRdBtn3.checked) == false)
    return !(inputTitleModal.value.length && txtAreaDescripcion.value.length && inputDeliveryDate.value.length !=0) || bool;

}

export const btnChecked = (inputRdBtn1,inputRdBtn2) =>{

    if(inputRdBtn1.checked ){
        return 1
    }else if(inputRdBtn2.checked){
        return 2
    }else{
        return 3
    }
    
}

export const columnCheck = (task, divTask,divTodo,divInprocess,divFinish) => {
    task.column === 1 ? divTodo.append(divTask) : task.column === 2? divInprocess.append(divTask):
            divFinish.append(divTask)
}

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

export const eliminarLog = async(idLog)=>{

    await deleteFunction(urlLog, idLog)

}