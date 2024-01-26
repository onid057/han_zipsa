package com.a407.back.dto.Zipsa;

import com.a407.back.domain.Room;
import com.a407.back.dto.util.ZipsaRecordsList;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ZipsaRecordsResponse {

    private final List<ZipsaRecordsList> list;


    public ZipsaRecordsResponse(List<Room> roomList) {

        this.list = new ArrayList<>();
        for (Room room : roomList) {
            list.add(new ZipsaRecordsList(room));
        }

    }
}