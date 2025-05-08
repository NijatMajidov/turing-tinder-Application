package az.turing.newapp.mapper;

public interface EntityMapper <T, D> {
    T toEntity(D dto);
    D toDto(T entity);
}
