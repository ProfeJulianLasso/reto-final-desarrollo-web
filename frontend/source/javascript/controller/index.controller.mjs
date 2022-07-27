"use strict";

// Services
import { MyUsersService } from "../model/services/my-users.service.mjs";

// Views
import { IndexView } from "../view/index.view.mjs";

class IndexController {
    #privateView;
    #privateMyUsersService;

    constructor() {
        const headerData = ['nombre', 'apellidos', 'correo', 'teléfono', 'creado', 'acciones'];
        this.#privateView = new IndexView(headerData);
        this.#privateMyUsersService = new MyUsersService();
    }

    async init() {
        this.#privateView.Data = await this.#privateMyUsersService.getUsers();
        this.#privateView.init();
    }
}

export const index = new IndexController();
index.init();