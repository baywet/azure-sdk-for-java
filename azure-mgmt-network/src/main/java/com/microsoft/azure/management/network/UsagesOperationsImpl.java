/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.13.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.network;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.management.network.models.UsagesListResult;
import com.microsoft.rest.AzureServiceResponseBuilder;
import com.microsoft.rest.CloudException;
import com.microsoft.rest.serializer.AzureJacksonUtils;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in UsagesOperations.
 */
public final class UsagesOperationsImpl implements UsagesOperations {
    /** The Retrofit service to perform REST calls. */
    private UsagesService service;
    /** The service client containing this operation class. */
    private NetworkManagementClient client;

    /**
     * Initializes an instance of UsagesOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public UsagesOperationsImpl(Retrofit retrofit, NetworkManagementClient client) {
        this.service = retrofit.create(UsagesService.class);
        this.client = client;
    }

    /**
     * Lists compute usages for a subscription.
     *
     * @param location The location upon which resource usage is queried.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UsagesListResult object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<UsagesListResult> list(String location) throws CloudException, IOException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Parameter location is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.list(location, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        return listDelegate(call.execute(), null);
    }

    /**
     * Lists compute usages for a subscription.
     *
     * @param location The location upon which resource usage is queried.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> listAsync(String location, final ServiceCallback<UsagesListResult> serviceCallback) {
        if (location == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter location is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.list(location, this.client.getSubscriptionId(), this.client.getApiVersion(), this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<UsagesListResult>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(listDelegate(response, retrofit));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<UsagesListResult> listDelegate(Response<ResponseBody> response, Retrofit retrofit) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UsagesListResult, CloudException>(new AzureJacksonUtils())
                .register(200, new TypeToken<UsagesListResult>() { }.getType())
                .registerError(CloudException.class)
                .build(response, retrofit);
    }

    /**
     * Lists compute usages for a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UsagesListResult object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<UsagesListResult> listNext(String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        return listNextDelegate(call.execute(), null);
    }

    /**
     * Lists compute usages for a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> listNextAsync(String nextPageLink, final ServiceCallback<UsagesListResult> serviceCallback) {
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<UsagesListResult>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(listNextDelegate(response, retrofit));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<UsagesListResult> listNextDelegate(Response<ResponseBody> response, Retrofit retrofit) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<UsagesListResult, CloudException>(new AzureJacksonUtils())
                .register(200, new TypeToken<UsagesListResult>() { }.getType())
                .registerError(CloudException.class)
                .build(response, retrofit);
    }

}
