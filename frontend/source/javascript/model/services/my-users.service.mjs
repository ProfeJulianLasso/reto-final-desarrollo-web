import { Config } from "../../config.mjs";
import { UserModel } from "../user.model.mjs";

export class MyUsersService {

    constructor() { }

    async getUsers() {
        const data = await fetch(`${Config.BackendURL}/usuario/records`).then(response => response.json());
        const users = new Array();
        data.items.forEach(item => {
            const user = new UserModel(item);
            users.push(user);
        });
        return users;
    }

    async getUserById(id) {
        const data = await fetch(`${Config.BackendURL}/usuario/records/${id}`).then(response => response.json());
        return new UserModel(data);
    }

    async update(id, data) {
        await fetch(
            `${Config.BackendURL}/usuario/records/${id}`,
            {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

}