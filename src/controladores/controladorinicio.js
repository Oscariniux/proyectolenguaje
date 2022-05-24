exports.Inicio = (req, res) => {
    const listaModulos = [
        {modulo: "empleados", ruta:"/api/empleados"},
        {modulo: "clientes", ruta:"/api/clientes"},
    ];
    const msj = {
        api: "API-Sigres",
        descripcion: "Interfaz de programacion para el sistema de gestion de restaurantes",
        propietario: "Oscar",
        desarrollador: "Oscar",
        colaboradores: "",
        listaModulos,
    };
    res.json(msj);
};
