package bg.tu_varna.sit.si.user;


import bg.tu_varna.sit.si.user.dto.UserCreateDTO;
import bg.tu_varna.sit.si.user.dto.UserDetailDTO;
import bg.tu_varna.sit.si.user.dto.UserListDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResource {

    @GET
    public List<UserListDTO> getUsers() {
        return UserEntity.<UserEntity>listAll().stream().map(UserListDTO::new).toList();
    }

    @GET
    @Path("/{externalId}")
    public Response getUser(@PathParam("externalId") String externalId) {
        UserEntity user = UserEntity.find("externalUserId", externalId).firstResult();

        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


        return Response.ok(new UserDetailDTO(user)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserCreateDTO dto) {

        UserEntity user = new UserEntity();

        user.externalUserId = dto.externalUserId;
        user.firstName = dto.firstName;
        user.middleName = dto.middleName;
        user.lastName = dto.lastName;
        user.age = dto.age;
        user.email = dto.email;
        user.address = dto.address;
        user.cityId = dto.cityId;
        user.profileImageId = dto.profileImageId;


        user.setEgn(dto.egn);

        user.persist();

        return Response.status(Response.Status.CREATED)
                .entity(new UserDetailDTO(user))
                .build();
    }


}
