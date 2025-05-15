package az.turing.newapp.mapper;

public interface EntityMapper<T, Req, Res> {
    T toEntity(Req dto);   // D = Request DTO
    Res toDto(T entity);   // R = Response DTO
}
