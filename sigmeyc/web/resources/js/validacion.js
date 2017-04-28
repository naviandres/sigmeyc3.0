//validacion modal inicioDeSesión

$('#formInicio').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        txtCorreo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un correo válido'
                },
                regexp: {
                    regexp: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/,
                    message: 'No se aceptan caracteres especiales, es necesario el dominio'
                },
                stringLength: {
                    min: 5,
                    message: 'Mínimo 5 carácteres'
                }
            }
        },
        txtClv: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'La contraseña es requerida'
                }

            }
        }
    }
});

// By calling Bootstrap Material Design after calling .formValidation()
// you don't need to adjust the position of feedback icons


// contactenos
$(document).ready(function () {
    $('#contact').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            txtNombC: {//Validar con los aributos NAME de cada INPUT
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ingrese un nombre válido '

                    },
                    regexp: {
                        regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ/\s/a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/,
                        message: 'Solo letras, sin números o carácteres especiales'
                    },
                    stringLength: {
                        min: 7,
                        max: 20,
                        message: 'Mínimo 7 carácteres'
                    }
                }
            },
            txtApeeC: {//Validar con los aributos NAME de cada INPUT
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ingrese un nombre válido '

                    },
                    regexp: {
                        regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ/\s/a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/,
                        message: 'Solo letras, sin números o carácteres especiales'
                    },
                    stringLength: {
                        min: 7,
                        max: 20,
                        message: 'Mínimo 7 carácteres'
                    }
                }
            },
            correoE: {//Validar con los aributos NAME de cada INPUT
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ingrese un correo válido'
                    },
                    regexp: {
                        regexp: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/,
                        message: 'No se aceptan carácteres especiales,es necesario el dominio'
                    },
                    stringLength: {
                        min: 5,
                        message: 'Mínimo 5 carácteres'
                    }
                }
            },
            mensaje: {
                validators: {
                    notEmpty: {
                        message: 'Ingrese mensaje'
                    },
                    stringLength: {
                        min: 10,

                        message: 'Mínimo 10 carácteres'
                    }
                }
            }
        }
    });

    // By calling Bootstrap Material Design after calling .formValidation()
    // you don't need to adjust the position of feedback icons
});

//validacion modal registrarse

$('#registro').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        txtNombI: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un nombre válido '

                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ/\s/a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/,
                    message: 'Solo letras, sin números o carácteres especiales'
                },
                stringLength: {
                    min: 7,
                    max: 20,
                    message: 'Mínimo 7 carácteres'
                }
            }
        },
        txtApeeI: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un apellido válido '

                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ/\s/a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/,
                    message: 'Solo letras, sin números o carácteres especiales'
                },
                stringLength: {
                    min: 7,
                    max: 20,
                    message: 'Mínimo 7 carácteres'
                }
            }
        },
        txtCelI: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un número válido'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'No se aceptan caracteres especiales, es necesario el dominio'
                },
                stringLength: {
                    min: 10,
                    max: 10,
                    message: 'Mínimo 10 carácteres'
                }
            }
        },
        correo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un correo válido'
                },
                regexp: {
                    regexp: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/,
                    message: 'No se aceptan caracteres especiales, es necesario el dominio'
                },
                stringLength: {
                    min: 5,
                    message: 'Mínimo 5 carácteres'
                }
            }
        },
        contraseña: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese una contraseña válida'
                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 8,

                    message: 'Minimo 8 carácteres'
                }
            }
        },
        repetirContraseña: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Las contraseñas no coinciden'
                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 8,

                    message: 'Minimo 8 carácteres'
                },
                identical: {
                    field: 'contraseña',
                    message: 'Las contraseñas no coinciden'
                }
            }
        }
    }
});

//MostrarFormConsulta
$("#formBC").on('submit', function (evt) {
    evt.preventDefault();
    document.getElementById('consulta').style.display = 'block';
    document.getElementById('solicitar').style.display = 'none';
    document.getElementById('cotizar').style.display = 'none';
});
//MostrarSolicitar
$("#formBS").on('submit', function (evt) {
    evt.preventDefault();
    document.getElementById('solicitar').style.display = 'block';
    document.getElementById('consulta').style.display = 'none';
    document.getElementById('cotizar').style.display = 'none';
});
//MostrarFormCotizar
$("#formBCo").on('submit', function (evt) {
    evt.preventDefault();
    document.getElementById('cotizar').style.display = 'block';
    document.getElementById('solicitar').style.display = 'none';
    document.getElementById('consulta').style.display = 'none';
});

function ocultar() {
    document.getElementById('consulta').style.display = "none";
    document.getElementById('solicitar').style.display = 'none';
    document.getElementById('cotizar').style.display = 'none';
}
function mostrarDatosEmpr() {

    document.getElementById('txtNom').style.display = 'none';
    document.getElementById('txtApe').style.display = 'none';
    document.getElementById('txtCel').style.display = 'none';
    document.getElementById('selTDoc').style.display = 'none';
    document.getElementById('h1EnvioP').style.display = 'none';
    document.getElementById('h1EnvioE').style.display = 'block';
    document.getElementById('txtRazon').style.display = 'block';
    document.formSol.selePers.checked = false;
}
function mostrarDatosPers() {
    document.formSol.seleEmpre.checked = false;
    document.getElementById('txtNom').style.display = 'block';
    document.getElementById('txtApe').style.display = 'block';
    document.getElementById('txtCel').style.display = 'block';
    document.getElementById('selTDoc').style.display = 'block';
    document.getElementById('h1EnvioP').style.display = 'block';
    document.getElementById('h1EnvioE').style.display = 'none';
    document.getElementById('txtRazon').style.display = 'none';
}
function mostrarDatosEmprI() {
    document.getElementById('divRazI').style.display = 'block';
    document.getElementById('divNmbrs').style.display = 'none';
    document.getElementById('divContac').style.display = 'block';
    document.getElementById('divCorreo').style.display = 'block';
    document.getElementById('divContr').style.display = 'block';
    document.getElementById('divRepetContra').style.display = 'block';
    document.registro.selePersI.checked = false;
}
function mostrarDatosPersI() {
    document.registro.seleEmpreI.checked = false;
    document.getElementById('divRazI').style.display = 'none';
    document.getElementById('divNmbrs').style.display = 'block';
    document.getElementById('divContac').style.display = 'block';
    document.getElementById('divCorreo').style.display = 'block';
    document.getElementById('divContr').style.display = 'block';
    document.getElementById('divRepetContra').style.display = 'block';
}



