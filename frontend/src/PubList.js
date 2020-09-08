import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import SearchBar from './SearchBar';
import { Link } from 'react-router-dom';

class PubList extends Component {

    constructor(props) {
        super(props);
        this.state = {pubs: [], isLoading: true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.findPubs('')
    }

    findPubs(term) {
        console.log(term);

        this.setState({isLoading: true});

        fetch('api/pubs')
            .then(response => response.json())
            .then(data => this.setState({pubs: data.filter(pub => pub.name.toLowerCase().includes(term.toLowerCase())),
                                         isLoading: false}));
    }

    async remove(id) {
        await fetch(`/api/pub/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedPubs = [...this.state.pubs].filter(i => i.id !== id);
            this.setState({pubs: updatedPubs});
        });
    }

    render() {
        const {pubs, isLoading} = this.state;

        var pubList = null;
        if (!isLoading) {
                pubList = pubs.map(pub => {
                var address = '';

                if (pub.address != null) {
                    address = `${pub.address.addressLine}, ${pub.address.city}, ${pub.address.country}`;
                }

                return <tr key={pub.id}>
                    <td style={{whiteSpace: 'nowrap'}}>{pub.name}</td>
                    <td>{address}</td>
                    <td>{pub.consumables.map(consumable => {
                                       return <div key={consumable.id}>{consumable.name} - {consumable.description}</div>
                                   })}</td>
                    <td>
                        <ButtonGroup>
                            <Button size="sm" color="primary" tag={Link} to={"/pubs/" + pub.id}>Edit</Button>
                            <Button size="sm" color="danger" onClick={() => this.remove(pub.id)}>Delete</Button>
                        </ButtonGroup>
                    </td>
                </tr>
            });
        }

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/pubs/new">Add Pub</Button>
                    </div>
                    <h3>Available Pubs</h3>
                    <div>
                        Search: <SearchBar onSearchTermChange={term => this.findPubs(term)} />
                    </div>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="20%">Name</th>
                                <th width="20%">Location</th>
                                <th>On the offer</th>
                                <th width="10%">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {pubList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default PubList;