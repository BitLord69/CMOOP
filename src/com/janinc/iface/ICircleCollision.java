package com.janinc.iface;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-28
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public interface ICircleCollision extends ICollide {
    boolean isCollisionDetected(ICircleCollision circle);
}
