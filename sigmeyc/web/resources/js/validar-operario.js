//mostrar ruta
$().ready(function () {
    $(document).on('change', '#rout', function () {
        console.log($(this).val());
        var conduc = $(this).val();
        if (conduc === 'rut1') {
            $('.tabla').css('display', 'none');
            $('#tabla').css('display', 'block');
        }
    });
});
//mostrar conductor 
$().ready(function () {


    $(document).on('change', '#cd', function () {

        console.log($(this).val());
        var conduc = $(this).val();
        if (conduc === 'c01') {
            $('.driver').css('display', 'none');
            $('#cod01').css('display', 'block');
        }
        if (conduc === 'c02') {
            $('.driver').css('display', 'none');
            $('#cod02').css('display', 'block');
        }
        if (conduc === 'c03') {
            $('.driver').css('display', 'none');
            $('#cod03').css('display', 'block');
        }
        if (conduc === 'c04') {
            $('.driver').css('display', 'none');
            $('#cod04').css('display', 'block');
        }
        if (conduc === 'c05') {
            $('.driver').css('display', 'none');
            $('#cod05').css('display', 'block');
        }
    });
});

//TABLA GENERAR GUIAS

$(document).ready(function () {
    $('#tablaGuia').DataTable();
});
function mostrarDatosEmpr() {

    if ('seleEmpr') {
        document.getElementById('txtNom').style.display = 'none';
        document.getElementById('txtApe').style.display = 'none';
        document.getElementById('txtCel').style.display = 'none';
        document.getElementById('selTDoc').style.display = 'none';
        document.getElementById('h1EnvioP').style.display = 'none';
        document.getElementById('h1EnvioE').style.display = 'block';
        document.getElementById('txtRazon').style.display = 'block';
    } else {
        document.getElementById('txtNom').style.display = 'block';
        document.getElementById('txtApe').style.display = 'block';
        document.getElementById('txtCel').style.display = 'block';
        document.getElementById('selTDoc').style.display = 'block';
        document.getElementById('txtRazon').style.display = 'none';
    }
}