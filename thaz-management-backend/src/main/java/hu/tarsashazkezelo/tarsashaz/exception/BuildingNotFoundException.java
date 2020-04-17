package hu.tarsashazkezelo.tarsashaz.exception;


public class BuildingNotFoundException extends NotFoundException{
    public BuildingNotFoundException(Long id) {
        super("Building id: " + id + "is not found");
    }
}
