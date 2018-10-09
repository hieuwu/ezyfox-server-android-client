package com.tvd12.ezyfoxserver.client.codec;

import com.tvd12.ezyfoxserver.client.util.EzyResettable;

import java.nio.ByteBuffer;
import java.util.Queue;

public interface EzyByteToObjectDecoder extends EzyResettable {

	Object decode(EzyMessage message) throws Exception;
	
	void decode(ByteBuffer bytes, Queue<EzyMessage> queue) throws Exception;
	
}
