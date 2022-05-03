package org.shmurda.pq2.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@AllArgsConstructor
@Getter
public class Int3 {

    private int x, y, z;

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
