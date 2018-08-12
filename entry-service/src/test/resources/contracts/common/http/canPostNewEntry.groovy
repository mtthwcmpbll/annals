package common.http

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/entries'
        body([
                body: "This is a simple entry."
        ])
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body([
                id: $(regex(/[a-f\d]{24}/)),
                createdOn: $(regex(iso8601WithOffset())),
                body: 'This is a simple entry.'
        ])
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}