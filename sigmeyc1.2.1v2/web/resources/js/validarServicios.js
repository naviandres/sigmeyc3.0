//validarSolicitarEnvioP




//validarSolicitarEnvioP




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
                    min: 3,
                    message: 'Minimo 3 carácteres'
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

