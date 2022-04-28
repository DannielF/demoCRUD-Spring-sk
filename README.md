# Workshop SpringBoot and MySQL
    Spring Boot, JPA, MySQL, Unit testing

## Routes
    @Index
    localhost:8080/
    
    @GET
    /usuario
    /usuario/{id}
    /usuario/query?prioridad=?
    /usuario/rol
    /usuario/rol/{id}
    /usuario/rol/quey?rol=?

    @POST
    /usuario
    /usuario/rol
    
    @DELETE
    /usuario/{id}
    /usuario/rol/{id}

    @PUT
    /usuario/{id}
    /usuario/rol/{id}

## Why I chose @OneToMany
    I was following the instructions written in the Excel file
    and only ask for add one more entity, if you want to uses ManyToMany
    you need an intermediate table.

## Evidences
    @Get Usuario
![](./imagesTest/method_get_user.webp)

    @Post Usuario
![](./imagesTest/method_post_user.webp)

    @Get UsuarioRol
![](./imagesTest/method_get_userRol.webp)

    @Get query UsuarioRol
![](./imagesTest/method_get_query_userRol.webp)

    @Post UsuarioRol
![](./imagesTest/method_post_userRol.webp)

    
