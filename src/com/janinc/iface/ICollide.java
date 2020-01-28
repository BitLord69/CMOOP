package com.janinc.iface;

import java.awt.*;

public interface ICollide{
    Rectangle getBounds();
    boolean isCollisionDetected(ICollide object);
}
