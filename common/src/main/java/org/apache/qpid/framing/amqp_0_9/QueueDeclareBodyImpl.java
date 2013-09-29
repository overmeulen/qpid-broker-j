/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

/*
 * This file is auto-generated by Qpid Gentools v.0.1 - do not modify.
 * Supported AMQP version:
 *   0-9
 */

package org.apache.qpid.framing.amqp_0_9;

import org.apache.qpid.codec.MarkableDataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.qpid.framing.*;
import org.apache.qpid.AMQException;

public class QueueDeclareBodyImpl extends AMQMethodBody_0_9 implements QueueDeclareBody
{
    private static final AMQMethodBodyInstanceFactory FACTORY_INSTANCE = new AMQMethodBodyInstanceFactory()
    {
        public AMQMethodBody newInstance(MarkableDataInput in, long size) throws AMQFrameDecodingException, IOException
        {
            return new QueueDeclareBodyImpl(in);
        }
    };

    public static AMQMethodBodyInstanceFactory getFactory()
    {
        return FACTORY_INSTANCE;
    }

    public static final int CLASS_ID =  50;
    public static final int METHOD_ID = 10;

    // Fields declared in specification
    private final int _ticket; // [ticket]
    private final AMQShortString _queue; // [queue]
    private final byte _bitfield0; // [passive, durable, exclusive, autoDelete, nowait]
    private final FieldTable _arguments; // [arguments]

    // Constructor
    public QueueDeclareBodyImpl(MarkableDataInput buffer) throws AMQFrameDecodingException, IOException
    {
        _ticket = readUnsignedShort( buffer );
        _queue = readAMQShortString( buffer );
        _bitfield0 = readBitfield( buffer );
        _arguments = readFieldTable( buffer );
    }

    public QueueDeclareBodyImpl(
                                int ticket,
                                AMQShortString queue,
                                boolean passive,
                                boolean durable,
                                boolean exclusive,
                                boolean autoDelete,
                                boolean nowait,
                                FieldTable arguments
                            )
    {
        _ticket = ticket;
        _queue = queue;
        byte bitfield0 = (byte)0;
        if( passive )
        {
            bitfield0 = (byte) (((int) bitfield0) | (1 << 0));
        }

        if( durable )
        {
            bitfield0 = (byte) (((int) bitfield0) | (1 << 1));
        }

        if( exclusive )
        {
            bitfield0 = (byte) (((int) bitfield0) | (1 << 2));
        }

        if( autoDelete )
        {
            bitfield0 = (byte) (((int) bitfield0) | (1 << 3));
        }

        if( nowait )
        {
            bitfield0 = (byte) (((int) bitfield0) | (1 << 4));
        }

        _bitfield0 = bitfield0;
        _arguments = arguments;
    }

    public int getClazz()
    {
        return CLASS_ID;
    }

    public int getMethod()
    {
        return METHOD_ID;
    }

    public final int getTicket()
    {
        return _ticket;
    }
    public final AMQShortString getQueue()
    {
        return _queue;
    }
    public final boolean getPassive()
    {
        return (((int)(_bitfield0)) & ( 1 << 0)) != 0;
    }
    public final boolean getDurable()
    {
        return (((int)(_bitfield0)) & ( 1 << 1)) != 0;
    }
    public final boolean getExclusive()
    {
        return (((int)(_bitfield0)) & ( 1 << 2)) != 0;
    }
    public final boolean getAutoDelete()
    {
        return (((int)(_bitfield0)) & ( 1 << 3)) != 0;
    }
    public final boolean getNowait()
    {
        return (((int)(_bitfield0)) & ( 1 << 4)) != 0;
    }
    public final FieldTable getArguments()
    {
        return _arguments;
    }

    protected int getBodySize()
    {
        int size = 3;
        size += getSizeOf( _queue );
        size += getSizeOf( _arguments );
        return size;
    }

    public void writeMethodPayload(DataOutput buffer) throws IOException
    {
        writeUnsignedShort( buffer, _ticket );
        writeAMQShortString( buffer, _queue );
        writeBitfield( buffer, _bitfield0 );
        writeFieldTable( buffer, _arguments );
    }

    public boolean execute(MethodDispatcher dispatcher, int channelId) throws AMQException
	{
    return ((MethodDispatcher_0_9)dispatcher).dispatchQueueDeclare(this, channelId);
	}

    public String toString()
    {
        StringBuilder buf = new StringBuilder("[QueueDeclareBodyImpl: ");
        buf.append( "ticket=" );
        buf.append(  getTicket() );
        buf.append( ", " );
        buf.append( "queue=" );
        buf.append(  getQueue() );
        buf.append( ", " );
        buf.append( "passive=" );
        buf.append(  getPassive() );
        buf.append( ", " );
        buf.append( "durable=" );
        buf.append(  getDurable() );
        buf.append( ", " );
        buf.append( "exclusive=" );
        buf.append(  getExclusive() );
        buf.append( ", " );
        buf.append( "autoDelete=" );
        buf.append(  getAutoDelete() );
        buf.append( ", " );
        buf.append( "nowait=" );
        buf.append(  getNowait() );
        buf.append( ", " );
        buf.append( "arguments=" );
        buf.append(  getArguments() );
        buf.append("]");
        return buf.toString();
    }

}
