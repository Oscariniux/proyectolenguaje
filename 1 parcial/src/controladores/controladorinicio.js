//const { request } = require("express");
const { validationResult } = require("express-validator");
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

exports.EjemploPost = (req, res) => {
    console.log(req.body);
    //const{ usuario, contrasena } = req.body;
    const validaciones = validationResult(req);
    console.log(validaciones.errors);
    const usuario2 = req.body.usuario;
    const contrasena2 = req.body.contrasena; 
    console.log(usuario2);
    console.log(contrasena2);
    const msj = {
        mensaje: 'Ninguno'
    };
    if(!usuario2 || !contrasena2)
        {
            msj.mensaje = 'Debe enviar los datos completos';
        }
    else{
        msj.mensaje = 'Peticion procesada con exito';
    }
    res.json(msj);
};

exports.EjemploPut = (req, res) => {
    const validaciones = validationResult(req);
    console.log(validaciones.errors);
    //console.log(req);
    const {id} = req.query;
    console.log(id);
    //const{ usuario, contrasena } = req.body;
    const usuario2 = req.body.usuario;
    const contrasena2 = req.body.contrasena;
    console.log(usuario2);
    console.log(contrasena2);
    const msj = {
        mensaje: 'Ninguno'
    };
    if(!usuario2 || !contrasena2)
        {
            msj.mensaje = 'Debe enviar los datos completos';
        }
    else{
        msj.mensaje = 'Peticion procesada con exito';
    }
    res.json(msj);
};

exports.EjemploDelete = (req, res) => {
    const validaciones = validationResult(req);
    console.log(validaciones.errors);
    //console.log(req);
    const {id} = req.query;
    console.log(id);
    
    const msj = {
        mensaje: 'Ninguno'
    };
    if(!id)
        {
            msj.mensaje = 'Debe enviar los datos completos';
        }
    else{
        msj.mensaje = 'Peticion procesada con exito';
    }
    res.json(msj);
};