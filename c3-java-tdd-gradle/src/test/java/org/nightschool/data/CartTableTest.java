package org.nightschool.data;

import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartTableTest {
    @Test
    public void should_be_empty_when_nothing_added() throws Exception {
        CartTable cartTable = new CartTable();

        List<Disk> disks = cartTable.disks;

        assertThat(disks.size(), is(0));
    }
}
