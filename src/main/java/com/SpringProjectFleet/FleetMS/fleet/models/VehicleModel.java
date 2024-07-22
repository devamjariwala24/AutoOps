package com.SpringProjectFleet.FleetMS.fleet.models;

import com.SpringProjectFleet.FleetMS.parameters.models.CommonObject;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {

}