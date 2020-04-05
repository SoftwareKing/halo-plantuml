# halo-plantuml

## 示例脚本

```
@startuml
!includeurl https://raw.githubusercontent.com/xuanye/plantuml-style-c4/master/core.puml
skinparam linetype ortho
skinparam rectangle {
 roundCorner 100
}
'!@Sketch
package plantUMLDDD <<Rectangle>> #8B9BAC{
class LocationShared <<(V,#148610) ValueObject>> #861F1B {}
hide LocationShared members

class DeliverySpecification <<(V,#148610) ValueObject>> #861F1B {}
hide DeliverySpecification members

class CargoRepository <<(R,#e2b8b8)Repository>> #FFFFFF {}
hide CargoRepository members

class LocationService <<(D,#AF1603) DomainService>> #544E15 {}
hide LocationService members

class CustomerShared <<(V,#148610) ValueObject>> #861F1B {}
hide CustomerShared members

class HandlingEvent <<(E,#FF7700)Entity>> #8ED4D1 {}
hide HandlingEvent members

class CarrierMovement <<(E,#FF7700)Entity>> #8ED4D1 {}
hide CarrierMovement members

class CustomerRepository <<(R,#e2b8b8)Repository>> #FFFFFF {}
hide CustomerRepository members

class Cargo <<(R,#5C95D1) AggregateRoot>> #D1A349 {}
hide Cargo members

class DeliveryHistory <<(E,#FF7700)Entity>> #8ED4D1 {}
hide DeliveryHistory members

class Location <<(V,#148610) ValueObject>> #861F1B {}
hide Location members

class Customer <<(E,#FF7700)Entity>> #8ED4D1 {}
hide Customer members

}
'!@Relation
HandlingEvent --> CarrierMovement
HandlingEvent --> Cargo

CustomerRepository --> Customer

DeliverySpecification --> LocationShared
DeliverySpecification --> LocationService

LocationShared --> Location

DeliveryHistory --> HandlingEvent

CustomerShared --> Customer

CarrierMovement --> LocationShared

Cargo --> DeliveryHistory
Cargo --> Customer
Cargo --> DeliverySpecification
Cargo --> CustomerShared

CargoRepository --> Cargo
@enduml
```

## 测试

![](/doc/1.png)

![](/doc/2.png)
