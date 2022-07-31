// Imports
import { BoardController } from "./Controller/Board_Controller.mjs"

// Contenedores html
const root = document.getElementById("root")

// Funciones
let launch = new BoardController()
launch.generateViews()


