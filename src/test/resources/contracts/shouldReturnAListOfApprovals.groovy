import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return a list of approvals with status 201'
    request{
        method GET()
        url '/approvals'
    }
    response{
        status 201
        body(["Swaraj", "Ruchika"])
    }
}