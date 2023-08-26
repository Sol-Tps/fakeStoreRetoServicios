#language: es
Característica: Crear, actualizar y eliminar usuario

  @PostUser
  Escenario: Crear un usuario exitoso
    Cuando consumo la url del servicio
    Entonces validamos la respuesta del servicio


  @PutUser
  Escenario: Actualizar un usuario
    Cuando consumo la url y actualizo la informacion
    Entonces validamos la respuesta del servidor


