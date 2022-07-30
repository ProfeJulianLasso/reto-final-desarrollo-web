import { tablerosModel } from "../Tableros.model.mjs";

export class TablerosService {
    #privateUrl;
    constructor(url) {
        this.#privateUrl = url;
    }

    async  getTableros() {
        const tablerosData = await this.#getData();
        const arrayTableros = new Array();
        tablerosData.data.forEach((element)=>{
            arrayTableros.push(new tablerosModel(element.id,element.name));
        });    
        return arrayTableros;
    }

    #getData(){
        return fetch(`${this.#privateUrl+'/board'}`).then(response => response.json());
    }

    async  getColumnNames() {
        const tablerosData = await fetch(`${this.#privateUrl+'/column'}`).then(response => response.json());
        const arrayTableros = new Array();
        
        tablerosData.data.forEach((element)=>{
            arrayTableros.push(new tablerosModel(element.id,element.name));
        });    

        return arrayTableros;
    }

    //getTaskFoBoard
    async  getTaskFoBoard(idBoard) {
        const tablerosData = await fetch(`${this.#privateUrl+'/taskbyidboard/'+idBoard}`).then(response => response.json());
        const arrayTableros = new Array();
        
        tablerosData.data.forEach((element)=>{
            arrayTableros.push(new tablerosModel(element.id,element.name,element.idColumn,element.description,element.create));
        });    

        return arrayTableros;
    }

    async  getTablerosId() {        
        const tableroData = await this.#getDataId();
        const arrayTablero = new Array();        
        arrayTablero.push(new tablerosModel(tableroData.id,tableroData.name/*,tableroData.image,tableroData.gender*/));
        return arrayTablero;
    }

    #getDataId(){
        return fetch(this.#privateUrl+'/board').then(response => response.json());
    }

    async create(data)
    {     
        await fetch(
            `${this.#privateUrl+'/board'}`,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

    
    async createTask(data)
    {     
        await fetch(
            `${this.#privateUrl+'/task'}`,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

    async editar(data,id)
    {     
        await fetch(
            `${this.#privateUrl+'/board'}/${id}`,
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

    async editarTarea(data,id)
    {     
        await fetch(
            `${this.#privateUrl+'/task'}/${id}`,
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

    async delete(id) {
      
        await fetch(
            `${this.#privateUrl+'/board'}/${id}`,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            }
        ).then(response => response.json());
    }

    async deleteTask(id) {
      
        await fetch(
            `${this.#privateUrl+'/task'}/${id}`,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            }
        ).then(response => response.json());
    }
}


