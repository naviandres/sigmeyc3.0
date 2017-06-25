//validacion vehiculo
$('#createVehicu').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        placaVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese vehiculo valido'
                },
                regexp: {
                    regexp: /^[A-Za-z]{3}[0-9]{3}+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 6,
                    max: 6,
                    message: 'Mínimo 6 carácteres'
                }
            }
        },
        modelo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese modelo'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        selTipoVe: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione tipo vehiculo'
                }

            }
        },
        marca: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese marca'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        selCapCarga: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione capacidad de carga'
                }

            }
        },
        estadoVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'La contraseña es requerida'
                }

            }
        }
    }
});
$('#editarVehiculo').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        placaVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese vehiculo valido'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 6,
                    max: 6,
                    message: 'Mínimo 6 carácteres'
                }
            }
        },
        modelo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese modelo'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        selTipoVehi: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione tipo vehiculo'
                }

            }
        },
        marca: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese marca'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        selCapCarg: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione capacidad de carga'
                }

            }
        },
        estadoVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'La contraseña es requerida'
                }

            }
        }
    }
});
///VALIDACION USUARIO
$('#createUsuario').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        
        selTipoIden: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione tipo identificacion'
                }

            }
        },
        documento: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese documento'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 9,
                    max: 9,
                    message: 'Se requiere 9 carácteres'
                }
            }
        },
        primerNombre: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese primer nombre'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        primerApellido: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese primer apellido'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        celular: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese celular de contacto'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 13,
                    max: 13,
                    message: 'Mínimo 13 carácteres'
                }
            }
        },
        email: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese email'
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
//        clave: {
//            validators: {
//                notEmpty: {
//                    message: 'La contraseña es obligatoria'
//                },
//                callback: {
//                    callback: function (value, validator, $field) {
//                        var password = $field.val();
//                        if (password == '') {
//                            return true;
//                        }
//
//                        var result = zxcvbn(password),
//                                score = result.score,
//                                message = result.feedback.warning || 'La contraseña es débil';
//
//                        // Update the progress bar width and add alert class
//                        var $bar = $('#strengthBar');
//                        switch (score) {
//                            case 0:
//                                $bar.attr('class', 'progress-bar progress-bar-danger')
//                                        .css('width', '1%');
//                                break;
//                            case 1:
//                                $bar.attr('class', 'progress-bar progress-bar-danger')
//                                        .css('width', '25%');
//                                break;
//                            case 2:
//                                $bar.attr('class', 'progress-bar progress-bar-danger')
//                                        .css('width', '50%');
//                                break;
//                            case 3:
//                                $bar.attr('class', 'progress-bar progress-bar-warning')
//                                        .css('width', '75%');
//                                break;
//                            case 4:
//                                $bar.attr('class', 'progress-bar progress-bar-success')
//                                        .css('width', '100%');
//                                break;
//                        }
//
//                        // We will treat the password as an invalid one if the score is less than 3
//                        if (score < 3) {
//                            return {
//                                valid: false,
//                                message: message
//                            };
//                        }
//                        return true;
//                    }
//                }
//            }
//        }
    }
});
$('#editarUsuario').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
       
        selTipoIden: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Seleccione tipo identificacion'
                }

            }
        },
        documento: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese documento'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 9,
                    max: 9,
                    message: 'Se requiere 9 carácteres'
                }
            }
        },
        primerNombre: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese primer nombre'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        primerApellido: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese primer apellido'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        segundoApellido: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese segundo apellido'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        celular: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese celular de contacto'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 13,
                    max: 13,
                    message: 'Mínimo 6 carácteres'
                }
            }
        },
        email: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese email'
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
        }
    }
});
//CREAR PLANILLA
$('#createPlanilla').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
       
        ruta: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese ruta'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        cantidadGuias: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese marca'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        estadoVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'La contraseña es requerida'
                }

            }
        }
    }
});
$('#editarPlanilla').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
       
        ruta: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese ruta'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        cantidadGuias: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese marca'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        estadoVehiculo: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'La contraseña es requerida'
                }

            }
        }
    }
});
///VALIDACION GUIAS
$('#createGuia').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
       
        serial: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese serial de guía'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        detalleMercancia: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese detalle mercancia'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 25,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        direccionDeEnvio: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Direccion de envio requerido'
                }

            }
        }
    }
});
$('#editarGuia').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        
        serial: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese serial de guía'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'Solo numeros'
                },
                stringLength: {
                    min: 4,
                    max: 15,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        detalleMercancia: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese detalle mercancia'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 4,
                    max: 25,
                    message: 'Mínimo 4 carácteres'
                }
            }
        },
        direccionDeEnvio: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Direccion de envio requerido'
                }

            }
        }
    }
});


