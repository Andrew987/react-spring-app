import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class PubEdit extends Component {

    emptyItem = {
        name: '',
        address: {
            addressLine: '',
            city: '',
            stateOrProvince: '',
            country: '',
            postalCode: ''
        }
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleAddressChange = this.handleAddressChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const pub = await (await fetch(`/api/pub/${this.props.match.params.id}`)).json();
            if (pub.address == null) {
                pub.address = {
                              addressLine: '',
                              city: '',
                              stateOrProvince: '',
                              country: '',
                              postalCode: ''
                          };
            }
            this.setState({item: pub});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

     handleAddressChange(event) {
            const target = event.target;
            const value = target.value;
            const name = target.name;
            let item = {...this.state.item};
            item.address[name] = value;
            this.setState({item});
        }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/api/pub', {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/pubs');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Pub' : 'Add Pub'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="addressLine">Address</Label>
                        <Input type="text" name="addressLine" id="addressLine" value={item.address.addressLine || ''}
                               onChange={this.handleAddressChange} autoComplete="address-level1"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="city">City</Label>
                        <Input type="text" name="city" id="city" value={item.address.city || ''}
                               onChange={this.handleAddressChange} autoComplete="address-level1"/>
                    </FormGroup>
                    <div className="row">
                        <FormGroup className="col-md-4 mb-3">
                            <Label for="stateOrProvince">State/Province</Label>
                            <Input type="text" name="stateOrProvince" id="stateOrProvince" value={item.address.stateOrProvince || ''}
                                   onChange={this.handleAddressChange} autoComplete="address-level1"/>
                        </FormGroup>
                        <FormGroup className="col-md-5 mb-3">
                            <Label for="country">Country</Label>
                            <Input type="text" name="country" id="country" value={item.address.country || ''}
                                   onChange={this.handleAddressChange} autoComplete="address-level1"/>
                        </FormGroup>
                        <FormGroup className="col-md-3 mb-3">
                            <Label for="country">Postal Code</Label>
                            <Input type="text" name="postalCode" id="postalCode" value={item.address.postalCode || ''}
                                   onChange={this.handleAddressChange} autoComplete="address-level1"/>
                        </FormGroup>
                    </div>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/pubs">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(PubEdit);