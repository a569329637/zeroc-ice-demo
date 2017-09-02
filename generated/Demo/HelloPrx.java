// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `Hello.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Demo;

public interface HelloPrx extends Ice.ObjectPrx
{
    public String sayHello(String name);

    public String sayHello(String name, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sayHello(String name);

    public Ice.AsyncResult begin_sayHello(String name, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_sayHello(String name, Ice.Callback __cb);

    public Ice.AsyncResult begin_sayHello(String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_sayHello(String name, Callback_Hello_sayHello __cb);

    public Ice.AsyncResult begin_sayHello(String name, java.util.Map<String, String> __ctx, Callback_Hello_sayHello __cb);

    public Ice.AsyncResult begin_sayHello(String name, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sayHello(String name, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_sayHello(String name, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_sayHello(String name, 
                                          java.util.Map<String, String> __ctx, 
                                          IceInternal.Functional_GenericCallback1<String> __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb);

    public String end_sayHello(Ice.AsyncResult __result);
}
