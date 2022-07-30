"use strict";

// Services
import { BoardsService } from "../model/services/boards.service.mjs";

// Views
import { IndexView } from "../view/index.view.mjs";

class IndexController {
    #privateView;
    #privateBoardsService;
    #privateMyUsersService;

    constructor() {
        this.#privateView = new IndexView();
        this.#privateBoardsService = new BoardsService();
    }

    async init() {
        this.#privateView.Data = await this.#privateBoardsService.getBoards();
        this.#privateView.init();
    }
}

export const index = new IndexController();
index.init();