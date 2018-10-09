package com.tvd12.ezyfoxserver.client.msgpack;

import com.tvd12.ezyfoxserver.client.builder.EzyBuilder;
import com.tvd12.ezyfoxserver.client.codec.EzyMessageSerializer;
import com.tvd12.ezyfoxserver.client.codec.EzyObjectToBytes;

public class MsgPackObjectToBytes implements EzyObjectToBytes {

	private EzyMessageSerializer serializer;
	
	protected MsgPackObjectToBytes(Builder builder) {
		this.serializer = builder.serializer;
	}
	
	@Override
	public byte[] convert(Object object) {
		try {
			return serializer.serialize(object);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder implements EzyBuilder<MsgPackObjectToBytes> {
		private EzyMessageSerializer serializer;
		
		public Builder serializer(EzyMessageSerializer serializer) {
			this.serializer = serializer;
			return this;
		}
		
		@Override
		public MsgPackObjectToBytes build() {
			return new MsgPackObjectToBytes(this);
		}
	}

}
