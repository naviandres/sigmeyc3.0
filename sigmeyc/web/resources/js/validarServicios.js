//validarSolicitarEnvioP
$(document).ready(function () {
    FormValidation.Validator.placeholder = {
        validate: function (validator, $field, options) {
            return $field.attr('placeholder') != $field.val();
        }
    };

    $('#formSol').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            txtNom: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Nombre requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtApe: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Apellido requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtCel: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Celular requerido (Si no poseé de lo contrario de lo contrario ingrese 031+Teléfono)'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selTDoc: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tipo de documento requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtDocI: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Documento requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selTiS: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tipo de servicio requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            lblpesoMer: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Peso requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtValor: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Valor requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selPrioridad: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Prioridad requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selCiud: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Seleccionar ciudad requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtdirDeRecoleccion: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Dirección requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selCiudDes: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ciudad de destino requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtDirEntre: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Dirección requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtLargo: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Largo requerido'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtAncho: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ancho requerido'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtAltura: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Altura rquerida requerida'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtNombrers: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Nombre y apellido destinatario requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtDIN: {
                validators: {
                    notEmpty: {
                        message: 'Identificacion destinatario requerido'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    },
                    // Using the callback validator
                    callback: {
                        message: 'Debe ser diferente a la opción pre-establecida',
                        callback: function (value, validator, $field) {
                            return value != $field.attr('placeholder');
                        }
                    }
                }
            },
            txtTelD: {
                validators: {
                    notEmpty: {
                        message: 'Telefono requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    },
                    // Using the callback validator
                    callback: {
                        message: 'Debe ser diferente a la opción pre-establecida',
                        callback: function (value, validator, $field) {
                            return value != $field.attr('placeholder');
                        }
                    }
                }
            }
        }
    });
});

//validarConsultar
$('#formConsul').formValidation({
    framework: 'bootstrap',
    excluded: ':disabled',
    icon: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        txtCod: {//Validar con los aributos NAME de cada INPUT
            row: '.form-group',
            validators: {
                notEmpty: {
                    message: 'Ingrese el numero de la guia'
                },
                regexp: {
                    regexp: /^[0-9]+$/,
                    message: 'No se aceptan carácteres especiales'
                },
                stringLength: {
                    min: 8,
                    message: 'Minimo 8 carácteres'
                }
            }
        }
    }
});

//validarCotizar
$(document).ready(function () {
    FormValidation.Validator.placeholder = {
        validate: function (validator, $field, options) {
            return $field.attr('placeholder') != $field.val();
        }
    };

    $('#formCot').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            selTipSC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tipo de servicio requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtCantid: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tipo de mercancía requerida'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selTipoMercC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tipo de mercancía requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtPesoC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Peso mercancía requerido'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtValorC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Valor declarado requerido'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selPrioridadC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Priorización requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selCiudC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Tiempo de urgencia requerido'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            selCiudDesC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ciudad destino requerida'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtLargoC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Longitud de la mercancía requerida'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtAnchoC: {
                row: '.form-group',
                validators: {
                    notEmpty: {
                        message: 'Ancho de la mercancía requerida'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    }
                }
            },
            txtAlturaC: {
                validators: {
                    notEmpty: {
                        message: 'Altura de la mercancía requerida'
                    },
                    regexp: {
                        regexp: /^[ñÑáéíóúÁÉÍÓÚ0-9]+$/,
                        message: 'No se aceptan carácteres especiales'
                    },
                    // Using a custom validator named 'placeholder' created above
                    placeholder: {
                        message: 'Debe ser diferente a la opción pre-establecida'
                    },
                    // Using the callback validator
                    callback: {
                        message: 'Debe ser diferente a la opción pre-establecida',
                        callback: function (value, validator, $field) {
                            return value != $field.attr('placeholder');
                        }
                    }
                }
            }
        }
    });
});

