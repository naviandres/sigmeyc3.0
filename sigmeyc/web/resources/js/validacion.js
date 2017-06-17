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
                    min: 3,
                    max: 20,
                    message: 'Mínimo 3 carácteres'
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
                    min: 3,
                    max: 20,
                    message: 'Mínimo 3 carácteres'
                }
            }
        },
        nit: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese nit valido'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 10,
                    max: 10,
                    message: 'Se requieren 10 caracteresz'
                }
            }
        },
        txtRazonS: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese razon social valida '

                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ/\s/a-zA-ZñÑáéíóúÁÉÍÓÚ]+$/,
                    message: 'Solo letras, sin números o carácteres especiales'
                },
                stringLength: {
                    min: 3,
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
                    message: 'Solo numeros'
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
        txtDocume: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese un documento valido'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 9,
                    max: 9,
                    message: 'Se requieren 9 caracteres'
                }
            }
        },
        clave: {
            validators: {
                notEmpty: {
                    message: 'La contraseña es obligatoria'
                },
                callback: {
                    callback: function (value, validator, $field) {
                        var password = $field.val();
                        if (password == '') {
                            return true;
                        }

                        var result = zxcvbn(password),
                                score = result.score,
                                message = result.feedback.warning || 'La contraseña es débil';

                        // Update the progress bar width and add alert class
                        var $bar = $('#strengthBar');
                        switch (score) {
                            case 0:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '1%');
                                break;
                            case 1:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '25%');
                                break;
                            case 2:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '50%');
                                break;
                            case 3:
                                $bar.attr('class', 'progress-bar progress-bar-warning')
                                        .css('width', '75%');
                                break;
                            case 4:
                                $bar.attr('class', 'progress-bar progress-bar-success')
                                        .css('width', '100%');
                                break;
                        }

                        // We will treat the password as an invalid one if the score is less than 3
                        if (score < 3) {
                            return {
                                valid: false,
                                message: message
                            };
                        }
                        return true;
                    }
                }
            }
        },
        claveEmpre: {
            validators: {
                notEmpty: {
                    message: 'La contraseña es obligatoria'
                },
                callback: {
                    callback: function (value, validator, $field) {
                        var password = $field.val();
                        if (password == '') {
                            return true;
                        }

                        var result = zxcvbn(password),
                                score = result.score,
                                message = result.feedback.warning || 'La contraseña es débil';

                        // Update the progress bar width and add alert class
                        var $bar = $('#strengthBar');
                        switch (score) {
                            case 0:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '1%');
                                break;
                            case 1:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '25%');
                                break;
                            case 2:
                                $bar.attr('class', 'progress-bar progress-bar-danger')
                                        .css('width', '50%');
                                break;
                            case 3:
                                $bar.attr('class', 'progress-bar progress-bar-warning')
                                        .css('width', '75%');
                                break;
                            case 4:
                                $bar.attr('class', 'progress-bar progress-bar-success')
                                        .css('width', '100%');
                                break;
                        }

                        // We will treat the password as an invalid one if the score is less than 3
                        if (score < 3) {
                            return {
                                valid: false,
                                message: message
                            };
                        }
                        return true;
                    }
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
                identical: {
                    field: 'clave',

                    message: 'Las contraseñas no coinciden'
                }
            }
        },
        txtRep: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Las contraseñas no coinciden'
                },
                regexp: {
                    regexp: /^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                identical: {
                    field: 'claveEmpre',

                    message: 'Las contraseñas no coinciden'
                }
            }
        }
    }
});

//MostrarFormConsulta
$("#formBC").on('submit', function (evt) {
    evt.preventDefault();
    document.getElementById('btnRgis').style.display = 'none';

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
    document.formSol.selePers.checked = false;
    document.getElementById('txtNom').style.display = 'none';
    document.getElementById('txtApe').style.display = 'none';
    document.getElementById('txtCel').style.display = 'none';
    document.getElementById('selTDoc').style.display = 'none';
    document.getElementById('h1EnvioP').style.display = 'none';
    document.getElementById('h1EnvioE').style.display = 'block';
    document.getElementById('txtRazon').style.display = 'block';

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
    document.registro.selePersI.checked = false;
    //desactiva input y con el la validacion
    document.getElementById("nit").disabled = false;

    document.getElementById("txtRazonS").disabled = false;
    document.getElementById("txtNombI").disabled = true;
    document.getElementById("txtApeeI").disabled = true;
    document.getElementById("segundoApellido").disabled = true;
    document.getElementById("tipoIdentificacion").disabled = true;
    document.getElementById("txtDocume").disabled = true;
    document.getElementById("txtCelEmpre").disabled = false;
    document.getElementById("txtCelI").disabled = true;

    document.getElementById("btnRegEmpre").style.display = 'block';
    document.getElementById("btnRegUs").style.display = 'none';
    document.getElementById('divEmailUsuari').style.display = 'none';
    document.getElementById('divClaveUsau').style.display = 'none';
    document.getElementById('divEmailEmpre').style.display = 'block';
    document.getElementById('divClaveEmpre').style.display = 'block';
    document.getElementById("correo").disabled = true;
    document.getElementById("clave").disabled = true;
    document.getElementById("correoEmpre").disabled = false;
    document.getElementById("claveEmpre").disabled = false;
    //muestra los campos
    document.getElementById('divRazI').style.display = 'block';
    document.getElementById('divNit').style.display = 'block';
    document.getElementById('divNmbrs').style.display = 'none';
    document.getElementById('divApell').style.display = 'none';
    document.getElementById('divTipoIde').style.display = 'none';
    document.getElementById('divDocume').style.display = 'none';
    document.getElementById('divContac').style.display = 'none';
    document.getElementById('divContaEmpre').style.display = 'block';
    document.getElementById('divCorreo').style.display = 'block';
    document.getElementById('divContr').style.display = 'block';
    document.getElementById('divRepetEmpre').style.display = 'block';
    document.getElementById('divRepetContra').style.display = 'none';

}
function mostrarDatosPersI() {
    document.registro.seleEmpreI.checked = false;
    //desactiva input y con el la validacion
    document.getElementById("nit").disabled = true;
    document.getElementById("txtRazonS").disabled = true;
    document.getElementById("txtNombI").disabled = false;
    document.getElementById("txtApeeI").disabled = false;
    document.getElementById("segundoApellido").disabled = false;
    document.getElementById("tipoIdentificacion").disabled = false;
    document.getElementById("txtDocume").disabled = false;
    document.getElementById("txtCelI").disabled = false;
    document.getElementById("txtCelEmpre").disabled = true;

    document.getElementById('divEmailUsuari').style.display = 'block';
    document.getElementById('divClaveUsau').style.display = 'block';
    document.getElementById('divEmailEmpre').style.display = 'none';
    document.getElementById('divClaveEmpre').style.display = 'none';
    document.getElementById("correo").disabled = false;
    document.getElementById("clave").disabled = false;
    document.getElementById("correoEmpre").disabled = true;
    document.getElementById("claveEmpre").disabled = true;
    //muestra los campos
    document.getElementById("btnRegEmpre").style.display = 'none';
    document.getElementById("btnRegUs").style.display = 'block';
    document.getElementById('divRazI').style.display = 'none';
    document.getElementById('divNit').style.display = 'none';
    document.getElementById('divNmbrs').style.display = 'block';
    document.getElementById('divApell').style.display = 'block';
    document.getElementById('divTipoIde').style.display = 'block';
    document.getElementById('divDocume').style.display = 'block';
    document.getElementById('divContac').style.display = 'block';
    document.getElementById('divContaEmpre').style.display = 'none';
    document.getElementById('divRepetEmpre').style.display = 'none';
    document.getElementById('divRepetContra').style.display = 'block';

}

function pregunta() {
    if (confirm('¿Estas seguro de enviar este formulario?')) {
        document.tuformulario.submit();
    }
}


function error() {
    document.getElementById('mensa').window.alert('hola');
}
window.onload = function () {
    document.getElementById('#').onclick = function () {
        var clave = document.getElementById('txtClv');
        if (clave === null) {
            alert('hola mundo!');

        }
    };
};

//Tabss
$('#myTabs a').click(function (e) {
    e.preventDefault()
    $(this).tab('show')
})
$(document).ready(function () {
    $(".nav-tabs a").click(function () {
        $(this).tab('show');
    });
    $('.nav-tabs a').on('show.bs.tab', function () {
        alert('Debe registrar solicitud');
    });

});
function mostrarTab() {
    $('#mercancia').tab('show');
}

